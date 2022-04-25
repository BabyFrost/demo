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
//	        	bat "docker build -t localhost:5000/voufi/demo:${BUILD_TIMESTAMP} ."
	        	bat "docker build -t localhost:5000/voufi/demo:latest ."
	        }
	    }
	    
	    stage( "Docker Push" ) {
	        steps {
//	            bat "docker push localhost:5000/voufi/demo:${BUILD_TIMESTAMP}"
	            bat "docker push localhost:5000/voufi/demo:latest"
	        }
	    }
	    
	    stage( "Apply Kubernetes files " ) {
	    	steps {
	            withKubeConfig([ credentialsId: 'jenkins-robot', serverUrl: 'http://127.0.0.1:57710'] ) {
	            	bat "kubectl set image deployment/demo-deployment demo=demo:latest --record"
 //     				bat "kubectl apply -f demo-deployment.yaml"
    			}
	        }
	    }
	    
	}
}