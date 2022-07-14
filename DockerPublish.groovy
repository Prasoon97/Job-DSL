job('Docker_Publish')
{
  scm
  {
    git('https://github.com/Prasoon97/OnlineShoppingApi.git'){ node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Prasoon007')
            node / gitConfigEmail('prasoonchaubey97@gmail.com')
    }
  }
   triggers {
        scm('H/5 * * * *')
    }
   steps {
       dockerBuildAndPublish {
            repositoryName('prasoonchaubey/docker-onlineshoppingapi')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
     batchFile('echo Published Successfully!')
    }
  
}
