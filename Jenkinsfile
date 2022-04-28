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
	        bat "docker build -t localhost:5000/voufi/demo:${BUILD_NUMBER} ."
	        }
	    }
	    
	    stage( "Docker Push" ) {
	        steps {
	      		bat "docker push localhost:5000/voufi/demo:${BUILD_NUMBER}"
	        }
	    }
	    
	    stage( "Kubernetes Deployment" ) {
	    	steps {
	            withKubeConfig([ credentialsId: 'jenkins-robot', serverUrl: 'http://127.0.0.1:8001'] ) {
	            	script {
  						try {
 //							bat "kubectl set image deployment/demo-deployment demo=127.0.0.1:5000/voufi/demo:${BUILD_NUMBER} --record"
  							bat "kubectl apply -f config.yaml"
  						} catch (Exception e) {
  							bat "kubectl create deployment demo-deployment --image=127.0.0.1:5000/voufi/demo:${BUILD_NUMBER} --replicas=1"
  							bat "kubectl apply -f config.yaml"
  						}
					}
    			}
	        }
	    }
	    
	}
}