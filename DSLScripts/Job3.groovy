job('project-a/ansible-test') {
    scm {
        git{
            remote{
                name('dada')
                url('git@172.21.0.11:/data/go-project/go-test')
                credentials('git-pass')
            }
	}
    }
    triggers {
        cron('#15 13 * * *')
    }
    steps {
        shell('ls')
        environmentVariables {
            envs(ANSIBLE_ROLES_PATH: 'ansible-deploy/roles', ANSIBLE_LOOKUP_PLUGINS: 'ansible-deploy/lookup_plugins',ANSIBLE_ETCD_URL: 'http://etcd.test.net:2379')
        }
        ansiblePlaybook('b.yml') {
            inventoryPath('ansible-deploy/hosts')
            ansibleName('ansible')
            limit('all,localhost')
            credentialsId('jenkins-pass')
            forks(150)
            unbufferedOutput(true)
            colorizedOutput(true)
        }
    }
}
