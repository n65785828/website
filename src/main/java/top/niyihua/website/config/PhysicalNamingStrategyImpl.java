package top.niyihua.website.config;


import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import java.io.Serializable;

public class PhysicalNamingStrategyImpl extends PhysicalNamingStrategyStandardImpl implements Serializable {

    public static final PhysicalNamingStrategyImpl INSTANCE = new PhysicalNamingStrategyImpl();

}