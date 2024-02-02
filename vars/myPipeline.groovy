def call(){
pipeline{
    agent any
    stages{
    stage("Git checkout"){
        script{
       git branch: 'node-dev', url: 'https://github.com/Manivannan0410/shared.git' 
        } 
    }
    }




}
}
