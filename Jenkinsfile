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
//	        	bat "docker build -t localhost:5000/voufi/demo:${BUILD_TIMESTAMP} ."
//	        	bat "docker build -t localhost:5000/voufi/demo:latest ."
	        }
	    }
	    
	    stage( "Docker Push" ) {
	        steps {
	      		bat "docker push localhost:5000/voufi/demo:${BUILD_NUMBER}"
//	            bat "docker push localhost:5000/voufi/demo:${BUILD_TIMESTAMP}"
//	            bat "docker push localhost:5000/voufi/demo:latest"
	        }
	    }
	    
	    stage( "Apply Kubernetes files " ) {
	    	steps {
	            withKubeConfig([ credentialsId: 'kube-jenkins-robot', serverUrl: 'http://127.0.0.1:8081'] ) {
	            	script {
  						try {
  							bat "kubectl set image -n default deployment/demo-deployment demo=192.168.65.2:5000/voufi/demo:${BUILD_NUMBER} --record"
//      						bat "kubectl set image deployment/demo-deployment demo=192.168.65.2:5000/voufi/demo:${BUILD_TIMESTAMP} --record"
  						} catch (Exception e) {
  							bat "kubectl create deployment -n default demo-deployment --image=192.168.65.2:5000/voufi/demo:${BUILD_NUMBER} --replicas=1"
  							bat "kubectl expose deployment -n default demo-deployment --type=LoadBalancer --name=demo-service"
//      						bat "kubectl apply -f demo-deployment.yaml"
  						}
					}
	            
//	            	bat "kubectl set image deployment/demo-deployment demo=192.168.65.2:5000/voufi/demo:${BUILD_TIMESTAMP} --record"
//     				bat "kubectl apply -f demo-deployment.yaml"
    			}
	        }
	    }
	    
	}
}