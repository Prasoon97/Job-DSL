job('OnlineShoppingAPI_JOB')
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
        batchFile('dotnet build OnlineShoppingApi\ndotnet build OnlineShoppingApi.Test\ndotnet test OnlineShoppingApi.Test\necho Build and Test Process Completed!')
  
    }
  
}
