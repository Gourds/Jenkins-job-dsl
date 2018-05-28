//def gitUrl = 'git://github.com/jenkinsci/job-dsl-plugin.git'
job('PROJ-sonar') {
    scm {
        git{
            remote{
                name('haha')
                url('git@172.21.0.11:/data/go-project/go-test')
                credentials('gitpass')
            }
	}
    }
    triggers {
        cron('15 13 * * *')
    }
    steps {
        shell('ls')
    }
}
