pipeline {
  agent any

  tools {
    maven 'Maven'
  }

  environment {
    PATH = "/usr/local/bin:/opt/homebrew/bin:/usr/bin:/bin:/usr/sbin:/sbin"
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build + Test') {
      steps { sh 'mvn -B clean test' }
    }

    stage('Package') {
      steps { sh 'mvn -B package -DskipTests' }
    }

    stage('Docker Build') {
      steps { sh 'docker build -t midterm-demo:${BUILD_NUMBER} .' }
    }

    stage('Docker Run (Deploy-ish)') {
      steps { sh 'docker run --rm midterm-demo:${BUILD_NUMBER}' }
    }
  }
}