pipeline {
	agent any
	environment {
        PATH="/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/Maven_3.8.2/bin:$PATH"
    }
	stages {
	    stage( "Compile" ) {
	        steps {
	            sh "mvn clean package"
	        }
	    }
	}
}