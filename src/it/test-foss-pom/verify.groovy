File file = new File( basedir, "build.log" );
assert file.exists();

String buildLog = file.getText("UTF-8");
assert buildLog =~ 'foss-jar-maven-plugin:.*:touch \\(default-touch\\)';
assert buildLog !=~ 'maven-enforcer-plugin:.*:enforce \\(default-enforce\\)';
assert buildLog !=~ 'maven-failsafe-plugin:.*:integration-test \\(default-integration-test\\)';