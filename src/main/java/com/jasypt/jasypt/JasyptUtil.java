package com.jasypt.jasypt;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.PBEConfig;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptUtil {
    private PooledPBEStringEncryptor encryptor;
    private SimpleStringPBEConfig config;
    private static JasyptUtil jasyptUtil;
    private String encryptKey = "Mandiri123";

    private JasyptUtil() {
        encryptor = new PooledPBEStringEncryptor();
        config = new SimpleStringPBEConfig();
        setConfig(null);
        setEncryptor();
    }

    private JasyptUtil(String encryptKey) {
        encryptor = new PooledPBEStringEncryptor();
        config = new SimpleStringPBEConfig();
        setConfig(encryptKey);
        setEncryptor();
    }

    public static JasyptUtil getInstance(){
        if (jasyptUtil ==null) {
            jasyptUtil = new JasyptUtil();
        }
        return jasyptUtil;
    }

    public String encrypt(String inputString){
        return "ENC("+encryptor.encrypt(inputString)+")";
    }

    public String decrypt(String encryptedString){
        if (encryptedString.contains("ENC"))
            encryptedString = encryptedString.substring(4,encryptedString.length()-1);
        return encryptor.decrypt(encryptedString);
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    private void setConfig(String newKey){
        config.setPassword(newKey==null?encryptKey:newKey);
        encryptKey = config.getPassword();
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
    }

    private void setEncryptor(){
        encryptor.setConfig(config);
    }

    public void changeEncryptKey(String encryptKey){
        jasyptUtil = new JasyptUtil(encryptKey);
    }
}
