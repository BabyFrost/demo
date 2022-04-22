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
	            withKubeConfig([ credentialsId: 'jenkins-robot', serverUrl: 'http://127.0.0.1:61986'] ) {
      				bat "kubectl apply -f demo-deployment.yaml"
    			}
	        }
	    }
	    
	    stage( "Expose Kubernete Services " ) {
	    	steps {
      			bat "minikube start"
	        }
	    }
	    
	}
}