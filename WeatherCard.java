import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 天气查询卡片示例
 * 模拟显示天气信息的卡片组件
 */
public class WeatherCard {
    
    // 天气信息内部类
    static class WeatherInfo {
        private String city;
        private int temperature;
        private String condition;
        private int humidity;
        private String windSpeed;
        private LocalDateTime updateTime;
        
        public WeatherInfo(String city, int temperature, String condition, 
                          int humidity, String windSpeed) {
            this.city = city;
            this.temperature = temperature;
            this.condition = condition;
            this.humidity = humidity;
            this.windSpeed = windSpeed;
            this.updateTime = LocalDateTime.now();
        }
        
        // Getter方法
        public String getCity() { return city; }
        public int getTemperature() { return temperature; }
        public String getCondition() { return condition; }
        public int getHumidity() { return humidity; }
        public String getWindSpeed() { return windSpeed; }
        public LocalDateTime getUpdateTime() { return updateTime; }
    }
    
    // 模拟天气数据（实际应用中应从API获取）
    public static WeatherInfo fetchWeatherData(String city) {
        // 这里使用模拟数据，实际项目中应调用天气API
        switch (city.toLowerCase()) {
            case "beijing":
                return new WeatherInfo("北京", 25, "晴", 45, "12km/h");
            case "shanghai":
                return new WeatherInfo("上海", 28, "多云", 65, "8km/h");
            case "guangzhou":
                return new WeatherInfo("广州", 32, "小雨", 80, "15km/h");
            case "shenzhen":
                return new WeatherInfo("深圳", 31, "雷阵雨", 75, "10km/h");
            default:
                return new WeatherInfo(city, 26, "阴", 55, "5km/h");
        }
    }
    
    // 显示天气卡片
    public static void displayWeatherCard(WeatherInfo weather) {
        String divider = "═".repeat(40);
        String thinDivider = "─".repeat(40);
        
        System.out.println("\n" + divider);
        System.out.println("          🌤️  天气卡片  🌤️");
        System.out.println(divider);
        System.out.println("📍 城市: " + weather.getCity());
        System.out.println(thinDivider);
        System.out.println("🌡️ 温度: " + weather.getTemperature() + "°C");
        System.out.println("☁️ 天气: " + getWeatherIcon(weather.getCondition()) + " " + weather.getCondition());
        System.out.println("💧 湿度: " + weather.getHumidity() + "%");
        System.out.println("💨 风速: " + weather.getWindSpeed());
        System.out.println(thinDivider);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("🕐 更新时间: " + weather.getUpdateTime().format(formatter));
        System.out.println(divider + "\n");
    }
    
    // 根据天气条件返回对应图标
    private static String getWeatherIcon(String condition) {
        switch (condition) {
            case "晴": return "☀️";
            case "多云": return "⛅";
            case "阴": return "☁️";
            case "小雨": return "🌧️";
            case "中雨": return "🌧️";
            case "大雨": return "⛈️";
            case "雷阵雨": return "⚡";
            case "雪": return "❄️";
            default: return "🌤️";
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 天气查询系统 ===\n");
        
        // 查询不同城市的天气
        String[] cities = {"Beijing", "Shanghai", "Guangzhou", "Shenzhen", "Hangzhou"};
        
        for (String city : cities) {
            WeatherInfo weather = fetchWeatherData(city);
            displayWeatherCard(weather);
            
            // 模拟延迟，避免输出太快
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("💡 提示：实际应用中可接入真实天气API获取实时数据");
    }
}
