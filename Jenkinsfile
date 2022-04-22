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
	        	bat "docker build -t localhost:5000/voufi/demo:${BUILD_TIMESTAMP} ."
	        }
	    }
	    
	    stage( "Docker Push" ) {
	        steps {
	        	try {
	        	    bat "docker rmi localhost:5000/voufi/demo"
	        	} catch (Exception e) { }
	            bat "docker push -f localhost:5000/voufi/demo:${BUILD_TIMESTAMP}"
	        }
	    }
	    
	    stage( "Apply Kubernetes files " ) {
	    	steps {
	            withKubeConfig([ credentialsId: 'jenkins-robot', serverUrl: 'http://127.0.0.1:55013'] ) {
//	            	bat "kubectl delete deployment demo-deployment"
      				bat "kubectl apply -f demo-deployment.yaml"
    			}
	        }
	    }
	    
	}
}