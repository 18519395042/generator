import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class App {

    public static void main(String[] args) {
        String[] tables = {"ea_game_switch","ea_version"};

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig()
                .setOutputDir("./src/main/java")
                .setFileOverride(true)
                .setActiveRecord(true)
                .setIdType(IdType.AUTO)
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setAuthor("luxuewei")
                .setServiceName("I%sService");


        // 数据源配置
        DataSourceConfig dataSource = new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("root")
                .setUrl("jdbc:mysql://127.0.0.1:3306/dxj?characterEncoding=utf8&userSSL=true&serverTimezone=GMT");


        // 策略配置
        StrategyConfig strategy = new StrategyConfig()
                .setCapitalMode(true)
                .setDbColumnUnderline(true)
                .setEntityLombokModel(true)
                .setEntityBuilderModel(true)
                .setTablePrefix(new String[]{"sys_", "qrtz_","ea_"})
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tables);


        // 包配置
        PackageConfig packageInfo = new PackageConfig()
                .setParent("com.ea.base")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");


        //执行
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(globalConfig);
        mpg.setDataSource(dataSource);
        mpg.setStrategy(strategy);
        mpg.setPackageInfo(packageInfo);
        mpg.execute();
    }
}
