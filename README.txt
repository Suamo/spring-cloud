Decrypting configuration properties:

1. Install Java Cryptography Extension
    download https://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
    copy all files to %JAVA_HOME%\jre\lib\security
2. Create bootstrap.properties with encrypt.key
3. Create encrypted string
    POST localhost:8888/encrypt
    POST localhost:8888/decrypt
4. Use encrypted string as a configuration value starting with a '{cipher}' prefix