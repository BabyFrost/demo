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
	    
	    stage( "Docker Push" ) {
	        steps {
	            bat "docker tag babyfrost/demo localhost:5000/babyfrost/demo"
	        }
	    }
	}
}