job('project-a/dadada') {
    scm {
        git{
            remote{
                name('dada')
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
