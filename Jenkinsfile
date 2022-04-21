pipeline {
	agent any
	
	stages {
	
	    stage( "Build" ) {
	        steps {
	            bat "mvn clean package"
	        }
	    }
	    	    
	    stage( "Docker Build" ) {
	        steps {
	        	bat "docker build -t localhost:5000/voufi/demo:latest ."
	        }
	    }
	    
	    stage( "Docker Push" ) {
	        steps {
	            bat "docker push localhost:5000/voufi/demo"
	        }
	    }
	    
	    stage( "Apply Kubernetes files " ) {
	        steps {
	            bat "kubectl apply -f demo-deployment.yaml"
	        }
	    }
	    
	}
}