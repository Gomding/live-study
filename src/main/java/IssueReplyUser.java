import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class IssueReplyUser {
    private static final String repositoryName = "whiteship/live-study";
    private static final String myPersonalToken = "";

    GitHub gitHub;

    public void start() throws IOException {

        connectGithubApi();

        GHRepository ghRepository = gitHub.getRepository(repositoryName);

        Map<String, Integer> participantMap = new HashMap<>();

        List<GHIssue> issues = ghRepository.getIssues(GHIssueState.ALL);

        for (GHIssue issue : issues) {
            List<GHIssueComment> commentList = issue.getComments();

            for (GHIssueComment ghIssueComment : commentList) {
                String participant = getCommentUserName(ghIssueComment);
                addParticipantMap(participantMap, participant);
            }
        }
        printDashboard(participantMap, issues.size());
    }

    private void connectGithubApi() throws IOException{
        gitHub = new GitHubBuilder().withOAuthToken(myPersonalToken).build();
    }

    private String getCommentUserName(GHIssueComment ghIssueComment) throws IOException{
        return ghIssueComment.getUser().getLogin();
    }

    private void addParticipantMap(Map<String, Integer> participantMap, String participant) {
        if (participantMap.containsKey(participant)) {
            Integer doHomeworks = participantMap.get(participant);
            participantMap.put(participant, ++doHomeworks);
        } else {
            participantMap.put(participant, 1);
        }
    }

    private void printDashboard(Map<String, Integer> participantMap, int issuesSize) {
        participantMap.forEach((key, value) -> {
            double percent = (double) (value * 100) / issuesSize;
            System.out.print("참여자 : " + key);
            System.out.printf(", 참여율 : %.2f\n", percent);
        });
    }
}
