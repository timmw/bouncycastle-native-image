An attempt to make BouncyCastle work with GraalVM Native Image

1. Modify $GRAALVM_HOME/conf/security/java.security, add `security.provider.13=org.bouncycastle.jce.provider.BouncyCastleProvider`
2. Get BouncyCastle provider jar `wget https://www.bouncycastle.org/download/bcprov-jdk15on-170.jar`
3. Compile class `$GRAALVM_HOME/bin/javac -cp bcprov-jdk15on-170.jar App.java`
4. Compile native-image `./compile`

See following output from compile:

```
> ./compile
Executing [
/home/tim/opt/graalvm-ce-java11-22.0.0.2/bin/java \
-XX:+UseParallelGC \
-XX:+UnlockExperimentalVMOptions \
-XX:+EnableJVMCI \
-Dtruffle.TrustAllTruffleRuntimeProviders=true \
-Dtruffle.TruffleRuntime=com.oracle.truffle.api.impl.DefaultTruffleRuntime \
-Dgraalvm.ForcePolyglotInvalid=true \
-Dgraalvm.locatorDisabled=true \
-Dsubstratevm.IgnoreGraalVersionCheck=true \
--add-exports=java.base/com.sun.crypto.provider=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.event=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.loader=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.logger=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.module=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.org.objectweb.asm=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.org.xml.sax.helpers=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.perf=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.ref=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.reflect=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.util.xml.impl=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.util.xml=ALL-UNNAMED \
--add-exports=java.base/sun.invoke.util=ALL-UNNAMED \
--add-exports=java.base/sun.net=ALL-UNNAMED \
--add-exports=java.base/sun.nio.ch=ALL-UNNAMED \
--add-exports=java.base/sun.reflect.annotation=ALL-UNNAMED \
--add-exports=java.base/sun.reflect.generics.reflectiveObjects=ALL-UNNAMED \
--add-exports=java.base/sun.reflect.generics.repository=ALL-UNNAMED \
--add-exports=java.base/sun.reflect.generics.tree=ALL-UNNAMED \
--add-exports=java.base/sun.security.jca=ALL-UNNAMED \
--add-exports=java.base/sun.security.provider=ALL-UNNAMED \
--add-exports=java.base/sun.security.ssl=ALL-UNNAMED \
--add-exports=java.base/sun.security.util=ALL-UNNAMED \
--add-exports=java.base/sun.text.spi=ALL-UNNAMED \
--add-exports=java.base/sun.util.calendar=ALL-UNNAMED \
--add-exports=java.base/sun.util.locale.provider=ALL-UNNAMED \
--add-exports=java.base/sun.util.resources=ALL-UNNAMED \
--add-exports=java.management/sun.management=ALL-UNNAMED \
--add-exports=java.xml.crypto/org.jcp.xml.dsig.internal.dom=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.aarch64=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.amd64=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.site=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.stack=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.common=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.aarch64=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.amd64=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.sparc=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.meta=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.runtime=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.services=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.sparc=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.events=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.internal.consumer=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.internal.handlers=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.internal.jfc=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.internal=ALL-UNNAMED \
-XX:+UseJVMCINativeLibrary \
-Xss10m \
-Xms1g \
-Xmx14g \
-Djava.awt.headless=true \
-Dorg.graalvm.version=22.0.0.2 \
-Dorg.graalvm.config=CE \
-Dcom.oracle.graalvm.isaot=true \
-Djava.system.class.loader=com.oracle.svm.hosted.NativeImageSystemClassLoader \
-Xshare:off \
-Djdk.internal.lambda.disableEagerInitialization=true \
-Djdk.internal.lambda.eagerlyInitialize=false \
-Djava.lang.invoke.InnerClassLambdaMetafactory.initializeLambdas=false \
-Xmx3g \
-agentlib:native-image-diagnostics-agent=c=org.bouncycastle.jce.provider.BouncyCastleProvider \
-javaagent:/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/builder/svm.jar=c=org.bouncycastle.jce.provider.BouncyCastleProvider \
-cp \
/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/builder/svm.jar:/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/builder/native-image-base.jar:/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/builder/svm-llvm.jar:/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/builder/pointsto.jar:/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/builder/llvm-platform-specific-shadowed.jar:/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/builder/javacpp-shadowed.jar:/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/builder/objectfile.jar:/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/builder/llvm-wrapper-shadowed.jar \
--module-path \
/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/truffle/truffle-api.jar \
'com.oracle.svm.hosted.NativeImageGeneratorRunner$JDK9Plus' \
-watchpid \
168700 \
-imagecp \
/home/tim/Projects/sandbox/bouncycastle-native-image/bcprov-jdk15on-170.jar:/home/tim/Projects/sandbox/bouncycastle-native-image:/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/library-support.jar \
-H:Path=/home/tim/Projects/sandbox/bouncycastle-native-image \
-H:GenerateDebugInfo=2 \
-H:Optimize=0 \
-H:+ReportExceptionStackTraces \
-H:+TraceSecurityServices \
-H:TraceClassInitialization=org.bouncycastle.jce.provider.BouncyCastleProvider \
-H:FallbackThreshold=0 \
-H:CLibraryPath=/home/tim/opt/graalvm-ce-java11-22.0.0.2/lib/svm/clibraries/linux-amd64 \
'-H:Class@explicit main-class=App' \
'-H:Name@main-class lower case as image name=app'
]
========================================================================================================================
GraalVM Native Image: Generating 'app'...
========================================================================================================================
[1/7] Initializing...                                                                                    (6.2s @ 0.09GB)
 Version info: 'GraalVM 22.0.0.2 Java 11 CE'
[2/7] Performing analysis...  [*]                                                                       (14.2s @ 0.41GB)
# Printing security services automatic registration to: /home/tim/Projects/sandbox/bouncycastle-native-image/reports/security_services_20220315_183843.txt
   2,580 (82.80%) of  3,116 classes reachable
   3,207 (60.92%) of  5,264 fields reachable
  11,441 (72.87%) of 15,700 methods reachable
     250 classes,     0 fields, and   356 methods registered for reflection

Error: Classes that should be initialized at run time got initialized during image building:
 org.bouncycastle.jce.provider.BouncyCastleProvider was unintentionally initialized at build time. org.bouncycastle.jce.provider.BouncyCastleProvider caused initialization of this class with the following trace:
        at org.bouncycastle.jce.provider.BouncyCastleProvider.<clinit>(BouncyCastleProvider.java:61)
        at jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Unknown Source)
        at jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
        at jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:490)
        at java.util.ServiceLoader$ProviderImpl.newInstance(ServiceLoader.java:780)
        at java.util.ServiceLoader$ProviderImpl.get(ServiceLoader.java:722)
        at java.util.ServiceLoader$3.next(ServiceLoader.java:1395)
        at sun.security.jca.ProviderConfig$ProviderLoader.load(ProviderConfig.java:340)
        at sun.security.jca.ProviderConfig$3.run(ProviderConfig.java:248)
        at sun.security.jca.ProviderConfig$3.run(ProviderConfig.java:242)
        at java.security.AccessController.doPrivileged(Unknown Source)
        at sun.security.jca.ProviderConfig.doLoadProvider(ProviderConfig.java:242)
        at sun.security.jca.ProviderConfig.getProvider(ProviderConfig.java:222)
        at sun.security.jca.ProviderList.loadAll(ProviderList.java:315)
        at sun.security.jca.ProviderList.removeInvalid(ProviderList.java:332)
        at sun.security.jca.Providers.getFullProviderList(Providers.java:174)
        at java.security.Security.getProviders(Security.java:457)
        at com.oracle.svm.hosted.SecurityServicesFeature.computeAvailableServices(SecurityServicesFeature.java:567)
        at com.oracle.svm.hosted.SecurityServicesFeature.registerServiceReachabilityHandlers(SecurityServicesFeature.java:473)
        at com.oracle.svm.hosted.SecurityServicesFeature.beforeAnalysis(SecurityServicesFeature.java:300)
        at com.oracle.svm.hosted.NativeImageGenerator.lambda$runPointsToAnalysis$9(NativeImageGenerator.java:695)
        at com.oracle.svm.hosted.NativeImageGenerator$$Lambda$369/0x00000007c0faf840.accept(Unknown Source)
        at com.oracle.svm.hosted.FeatureHandler.forEachFeature(FeatureHandler.java:74)
        at com.oracle.svm.hosted.NativeImageGenerator.runPointsToAnalysis(NativeImageGenerator.java:695)
        at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:537)
        at com.oracle.svm.hosted.NativeImageGenerator.run(NativeImageGenerator.java:494)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner.buildImage(NativeImageGeneratorRunner.java:426)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner.build(NativeImageGeneratorRunner.java:587)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner.main(NativeImageGeneratorRunner.java:126)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner$JDK9Plus.main(NativeImageGeneratorRunner.java:617)


com.oracle.svm.core.util.UserError$UserException: Classes that should be initialized at run time got initialized during image building:
 org.bouncycastle.jce.provider.BouncyCastleProvider was unintentionally initialized at build time. org.bouncycastle.jce.provider.BouncyCastleProvider caused initialization of this class with the following trace:
        at org.bouncycastle.jce.provider.BouncyCastleProvider.<clinit>(BouncyCastleProvider.java:61)
        at jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Unknown Source)
        at jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
        at jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:490)
        at java.util.ServiceLoader$ProviderImpl.newInstance(ServiceLoader.java:780)
        at java.util.ServiceLoader$ProviderImpl.get(ServiceLoader.java:722)
        at java.util.ServiceLoader$3.next(ServiceLoader.java:1395)
        at sun.security.jca.ProviderConfig$ProviderLoader.load(ProviderConfig.java:340)
        at sun.security.jca.ProviderConfig$3.run(ProviderConfig.java:248)
        at sun.security.jca.ProviderConfig$3.run(ProviderConfig.java:242)
        at java.security.AccessController.doPrivileged(Unknown Source)
        at sun.security.jca.ProviderConfig.doLoadProvider(ProviderConfig.java:242)
        at sun.security.jca.ProviderConfig.getProvider(ProviderConfig.java:222)
        at sun.security.jca.ProviderList.loadAll(ProviderList.java:315)
        at sun.security.jca.ProviderList.removeInvalid(ProviderList.java:332)
        at sun.security.jca.Providers.getFullProviderList(Providers.java:174)
        at java.security.Security.getProviders(Security.java:457)
        at com.oracle.svm.hosted.SecurityServicesFeature.computeAvailableServices(SecurityServicesFeature.java:567)
        at com.oracle.svm.hosted.SecurityServicesFeature.registerServiceReachabilityHandlers(SecurityServicesFeature.java:473)
        at com.oracle.svm.hosted.SecurityServicesFeature.beforeAnalysis(SecurityServicesFeature.java:300)
        at com.oracle.svm.hosted.NativeImageGenerator.lambda$runPointsToAnalysis$9(NativeImageGenerator.java:695)
        at com.oracle.svm.hosted.NativeImageGenerator$$Lambda$369/0x00000007c0faf840.accept(Unknown Source)
        at com.oracle.svm.hosted.FeatureHandler.forEachFeature(FeatureHandler.java:74)
        at com.oracle.svm.hosted.NativeImageGenerator.runPointsToAnalysis(NativeImageGenerator.java:695)
        at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:537)
        at com.oracle.svm.hosted.NativeImageGenerator.run(NativeImageGenerator.java:494)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner.buildImage(NativeImageGeneratorRunner.java:426)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner.build(NativeImageGeneratorRunner.java:587)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner.main(NativeImageGeneratorRunner.java:126)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner$JDK9Plus.main(NativeImageGeneratorRunner.java:617)


        at com.oracle.svm.core.util.UserError.abort(UserError.java:73)
        at com.oracle.svm.hosted.classinitialization.ConfigurableClassInitialization.checkDelayedInitialization(ConfigurableClassInitialization.java:555)
        at com.oracle.svm.hosted.classinitialization.ClassInitializationFeature.duringAnalysis(ClassInitializationFeature.java:167)
        at com.oracle.svm.hosted.NativeImageGenerator.lambda$runPointsToAnalysis$10(NativeImageGenerator.java:704)
        at com.oracle.svm.hosted.FeatureHandler.forEachFeature(FeatureHandler.java:74)
        at com.oracle.svm.hosted.NativeImageGenerator.lambda$runPointsToAnalysis$11(NativeImageGenerator.java:704)
        at com.oracle.graal.pointsto.PointsToAnalysis.runAnalysis(PointsToAnalysis.java:755)
        at com.oracle.svm.hosted.NativeImageGenerator.runPointsToAnalysis(NativeImageGenerator.java:702)
        at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:537)
        at com.oracle.svm.hosted.NativeImageGenerator.run(NativeImageGenerator.java:494)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner.buildImage(NativeImageGeneratorRunner.java:426)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner.build(NativeImageGeneratorRunner.java:587)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner.main(NativeImageGeneratorRunner.java:126)
        at com.oracle.svm.hosted.NativeImageGeneratorRunner$JDK9Plus.main(NativeImageGeneratorRunner.java:617)
------------------------------------------------------------------------------------------------------------------------
                        0.8s (3.5% of total time) in 13 GCs | Peak RSS: 1.52GB | CPU load: 3.21
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 /home/tim/Projects/sandbox/bouncycastle-native-image/app.build_artifacts.txt
========================================================================================================================
Failed generating 'app' after 20.8s.
Error: Image build request failed with exit status 1
com.oracle.svm.driver.NativeImage$NativeImageError: Image build request failed with exit status 1
        at com.oracle.svm.driver.NativeImage.showError(NativeImage.java:1770)
        at com.oracle.svm.driver.NativeImage.build(NativeImage.java:1477)
        at com.oracle.svm.driver.NativeImage.performBuild(NativeImage.java:1438)
        at com.oracle.svm.driver.NativeImage.main(NativeImage.java:1425)
```
