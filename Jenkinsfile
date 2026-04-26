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
      steps {
        checkout scm
      }
    }

    stage('Environment Info') {
      steps {
        sh 'java -version'
        sh 'mvn -version'
        sh 'docker --version'
      }
    }

    stage('Build + Unit Test') {
      steps {
        sh 'mvn -B clean test'
      }
    }

    stage('Package Application') {
      steps {
        sh 'mvn -B package -DskipTests'
      }
    }

    stage('Build Staging Docker Image') {
      steps {
        sh 'docker build -t midterm-demo:staging .'
      }
    }

    stage('Deploy to Staging') {
      steps {
        sh 'docker compose up --no-start midterm-app-staging'
        sh 'docker compose start midterm-app-staging'
      }
    }

    stage('Staging Smoke Test') {
      steps {
        sh 'docker logs midterm-app-staging'
      }
    }

    stage('Promote to Production') {
      steps {
        sh 'docker tag midterm-demo:staging midterm-demo:production'
      }
    }

    stage('Deploy to Production') {
      steps {
        sh 'docker compose up --no-start midterm-app-production'
        sh 'docker compose start midterm-app-production'
      }
    }

    stage('Production Log Review') {
      steps {
        sh 'docker logs midterm-app-production'
      }
    }
  }

  post {
    failure {
      echo 'Pipeline failed. Review Jenkins console output and Docker logs for incident response.'
    }

    success {
      echo 'Final project pipeline completed successfully.'
    }
  }
}