# RSA-Encryption-Decryption-Tool

The executable jar file is included in the rsa.tool/target directory of this repository. Download the rsa.tool-1.0-jar-with-dependencies.jar file
and run the following command.

java -jar rsa.tool-1.0-jar-with-dependencies.jar

See the running_tool.png in the repository for sample encyption and decryption output.

When running the tool, if you get "java.security.NoSuchProviderException: JCE cannot authenticate the provider BC" or "rsa.tool-1.0-jar-with-dependencies.jar has unsigned entries - rsa/tool/CryptoUtil.class" exceptions,
download the bcprov-ext-jdk16-1.46.jar file and copy it to the <JDK_HOME>/jre/lib/ext folder in your computer. Modify the <JDK_HOME>/jre/lib/security/java.security file and add a security provider as following.

security.provider.10=org.bouncycastle.jce.provider.BouncyCastleProvider 

In above, you can change the number 10 appropriately by looking at the existing security providers. Usually there are 9 security provider entries and if so add the above as the 10th.

You may download the above jar file from following link. The same jar file is included in the resources folder of this repository.

http://central.maven.org/maven2/org/bouncycastle/bcprov-ext-jdk16/1.46/bcprov-ext-jdk16-1.46.jar

Under the resources folder, a sample keystore file (wso2carbon.jks) is attached. You can test this sample with following.

private key alias: wso2carbon

keystore password: wso2carbon

private key password: wso2carbon

plain text: 84271a8652

encrypted text: QNz3doAuM4muiHUs2qENclCveK43kch/WUpJPVhvG47/H9rMyVAJCIz1Jd5HwiBRLU6LoEFXTd6a4E/7EWsDjt6MeaNvCNVCcTvG7PWTUvvqwHG5luJ3Mpv4agvVif0S7OsKE2GRhl17pnJsQa0kx78/bq0W9DzJfFlbEwFx1/U=


