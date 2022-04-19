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
	    
	    stage( "Docker Tag" ) {
	        steps {
	            bat "docker tag babyfrost/demo localhost:5000/babyfrost/demo"
	        }
	    }
	    
	    stage( "Docker Push" ) {
	        steps {
	            bat "docker push localhost:5000/babyfrost/demo"
	        }
	    }
	    
	    stage( "Kubernetes Deployment" ) {
	        steps {
	            bat "kubectl apply -f demo-deployment.yaml"
	        }
	    }
	    
	}
}