pipeline {
	agent any
	
	stages {
	
	    stage( "Compile" ) {
	        steps {
	            sh "mvn clean package"
	        }
	    }
	    
	    stage( "Docker build" ) {
	        steps {
	            sh "docker build -t babyfrost/demo:latest ."
	        }
	    }
	    
	}
}