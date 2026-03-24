#!/usr/bin/env python3
"""
Веб-скрапер для сбора заголовков с сайта и сохранения в CSV-файл.
"""

import requests
from bs4 import BeautifulSoup
import csv
import argparse
from urllib.parse import urlparse


def scrape_headers(url, max_headers=100, verify_ssl=True):
    """
    Собирает заголовки (теги h1-h6) с указанного сайта.
    
    Args:
        url: URL сайта для скрапинга
        max_headers: Максимальное количество заголовков для сбора
        verify_ssl: Проверять SSL сертификат
    
    Returns:
        Список словарей с информацией о заголовках
    """
    headers_data = []
    
    try:
        # Отправляем HTTP запрос
        response = requests.get(url, timeout=10, verify=verify_ssl)
        response.raise_for_status()
        
        # Парсим HTML контент
        soup = BeautifulSoup(response.text, 'html.parser')
        
        # Находим все заголовки h1-h6
        for level in range(1, 7):
            tag_name = f'h{level}'
            tags = soup.find_all(tag_name)
            
            for tag in tags:
                if len(headers_data) >= max_headers:
                    break
                
                text = tag.get_text(strip=True)
                if text:  # Пропускаем пустые заголовки
                    headers_data.append({
                        'level': level,
                        'tag': tag_name,
                        'text': text
                    })
            
            if len(headers_data) >= max_headers:
                break
        
        print(f"Найдено {len(headers_data)} заголовков")
        return headers_data
        
    except requests.exceptions.RequestException as e:
        print(f"Ошибка при запросе к сайту: {e}")
        return []
    except Exception as e:
        print(f"Ошибка при парсинге: {e}")
        return []


def save_to_csv(headers_data, filename='headers.csv'):
    """
    Сохраняет собранные заголовки в CSV-файл.
    
    Args:
        headers_data: Список словарей с данными о заголовках
        filename: Имя выходного CSV-файла
    """
    if not headers_data:
        print("Нет данных для сохранения")
        return False
    
    try:
        with open(filename, 'w', newline='', encoding='utf-8-sig') as csvfile:
            fieldnames = ['level', 'tag', 'text']
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            
            writer.writeheader()
            writer.writerows(headers_data)
        
        print(f"Данные успешно сохранены в файл: {filename}")
        return True
        
    except Exception as e:
        print(f"Ошибка при сохранении в CSV: {e}")
        return False


def main():
    # Настройка аргументов командной строки
    parser = argparse.ArgumentParser(
        description='Веб-скрапер для сбора заголовков с сайта'
    )
    parser.add_argument(
        'url',
        help='URL сайта для скрапинга'
    )
    parser.add_argument(
        '-o', '--output',
        default='headers.csv',
        help='Имя выходного CSV-файла (по умолчанию: headers.csv)'
    )
    parser.add_argument(
        '-m', '--max',
        type=int,
        default=100,
        help='Максимальное количество заголовков (по умолчанию: 100)'
    )
    parser.add_argument(
        '--no-verify-ssl',
        action='store_true',
        help='Не проверять SSL сертификат (для сайтов с самоподписанными сертификатами)'
    )
    
    args = parser.parse_args()
    
    # Проверка URL
    parsed_url = urlparse(args.url)
    if not parsed_url.scheme:
        args.url = 'https://' + args.url
        print(f"Добавлен протокол https://: {args.url}")
    
    print(f"Начинаем скрапинг сайта: {args.url}")
    print("-" * 50)
    
    # Сбор заголовков
    verify_ssl = not args.no_verify_ssl
    headers_data = scrape_headers(args.url, args.max, verify_ssl)
    
    if headers_data:
        # Вывод первых нескольких заголовков для примера
        print("\nПример найденных заголовков:")
        for i, header in enumerate(headers_data[:5]):
            print(f"  {header['tag']}: {header['text'][:60]}...")
        if len(headers_data) > 5:
            print(f"  ... и ещё {len(headers_data) - 5} заголовков")
        
        # Сохранение в CSV
        print("-" * 50)
        save_to_csv(headers_data, args.output)
    else:
        print("Заголовки не найдены или произошла ошибка")


if __name__ == '__main__':
    main()
