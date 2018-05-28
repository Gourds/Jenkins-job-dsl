import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

class JobUtil {
    static final String DirPrefix = 'Arvon-'
    static final String BranchName = 'Test'
    static final String GitBranchName = 'master'
    static final String GitUrl = 'git clone git@172.21.0.11:/data/go-project/go-test'
    static final String GitCredential = 'gitpass'
    static String GetJobName(jobName) {
        return BranchName+'/'+jobName
    }
    static def CreateJob(def job, Closure optionalClosure = null) {
        job.with {
            scm {
                git {
                    remote {
                        url GitUrl
                        credentials(GitCredential)
                    }
                    branch GitBranchName
                }
            wrappers {
                preBuildCleanup()
            }
            }
        }
}
