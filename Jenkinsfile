pipeline {
	agent any
	
	stages {
	
	    stage( "Compile" ) {
	        steps {
	            bat "mvn clean package"
	        }
	    }
	    	    
	    stage( "Docker build" ) {
	        steps {
	            bat "docker build -t babyfrost/demo:latest ."
	        }
	    }
	}
}