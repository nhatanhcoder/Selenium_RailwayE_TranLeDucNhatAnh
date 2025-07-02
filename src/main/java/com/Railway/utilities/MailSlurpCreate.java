package com.Railway.utilities;

import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.CreateInboxDto;
import com.mailslurp.models.InboxDto;

import java.util.Arrays;

public class MailSlurpCreate {
    public static void main(String[] args) {
        try {
            // ✅ Use your actual MailSlurp API key
            String apiKey = "1471f84fd84afa435302cfbc49bd9a0484917ce1841218d6b26c59eb4bc9130d";

            ApiClient defaultClient = Configuration.getDefaultApiClient();
            defaultClient.setApiKey(apiKey);

            InboxControllerApi inboxApi = new InboxControllerApi(defaultClient);

            // ✅ Set full custom options here
            CreateInboxDto inboxOptions = new CreateInboxDto()
                    .useShortAddress(true);

            InboxDto inbox = inboxApi.createInboxWithOptions(inboxOptions);
            System.out.println("✅ Inbox created: " + inbox.getEmailAddress());

        } catch (Exception e) {
            System.err.println("❌ Error creating inbox:");
            e.printStackTrace();
        }
    }
}
