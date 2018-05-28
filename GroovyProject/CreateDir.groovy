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

    static def CreateFolder(DslFactory dslFactory) {
        dslFactory.folder(BranchName) {
            displayName(DirPrefix+BranchName)
            description(DirPrefix+BranchName)
        }
        dslFactory.folder(BranchName+'/tools') {
            displayName('工具'+BranchName)
            description('tools'+BranchName)
        }
        dslFactory.folder(GetJobName('restart')) {
            displayName('重启任务'+BranchName)
            description('restart'+BranchName)
        }
        dslFactory.folder(GetJobName('deploy')) {
            displayName('部署任务'+BranchName)
            description('deploy'+BranchName)
        }
    }
}

JobUtil.CreateFolder(this)
