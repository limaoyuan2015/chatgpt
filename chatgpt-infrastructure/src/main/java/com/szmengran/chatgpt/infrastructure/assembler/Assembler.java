package com.szmengran.chatgpt.infrastructure.assembler;

import com.szmengran.chatgpt.domain.config.ChatGPTProperties;
import com.szmengran.chatgpt.domain.converter.Converter;
import com.szmengran.chatgpt.dto.chat.ChatCmd;
import com.szmengran.chatgpt.dto.chat.ChatCreateCmd;
import com.szmengran.chatgpt.dto.chat.ChatMessage;
import com.szmengran.chatgpt.dto.chat.ChatMessageRole;
import com.szmengran.cola.exception.Assert;

import java.util.List;
import java.util.Optional;

/**
 * @Author MaoYuan.Li
 * @Date 2023/5/4 15:44
 * @Version 1.0
 */
public class Assembler {
    
    public static ChatCreateCmd transform(ChatCmd chatCmd, ChatGPTProperties chatGPTProperties) {
        Assert.notNull(chatGPTProperties.getTemperature(), "config msg temperature can't be null");
        Assert.notNull(chatGPTProperties.getMaxTokens(), "default config token can't be null");
        Assert.notNull(chatGPTProperties.getModel(), "default config model can't be null");
        Assert.notNull(chatGPTProperties.getRole(), "default config role can't be null");
        List<ChatMessage> list = chatCmd.getMessages();
        Assert.isTrue(list != null && !list.isEmpty(), "question can't be null");
        list.forEach(msg -> {
            msg.setRole(Optional.ofNullable(msg.getRole()).orElse(chatGPTProperties.getRole()));
        });
        chatCmd.setMaxTokens(Optional.ofNullable(chatCmd.getMaxTokens()).orElse(chatGPTProperties.getMaxTokens()));
        chatCmd.setModel(Optional.ofNullable(chatCmd.getModel()).orElse(chatGPTProperties.getModel().get("chat")));
        chatCmd.setTemperature(Optional.ofNullable(chatCmd.getTemperature()).orElse(chatGPTProperties.getTemperature()));
        ChatCreateCmd chatCreateCmd =  Converter.INSTANCE.toChatCreateCmd(chatCmd);
        chatCreateCmd.getMessages().add(0, getSystemChatMessage());
        return chatCreateCmd;
    }
    
    private static ChatMessage getSystemChatMessage() {
//        String systemContent = String.format("You are a customer service representative for a company. " +
//                "Your task is to assist customers and provide helpful responses to their inquiries. " +
//                "Please remember not to disclose that you are an AI. Furthermore, " +
//                "avoid responding to any questions that are not related to customer service. " +
//                "Feel free to provide appropriate solutions and ensure a positive customer experience." +
//                "You need to reply by Chinese. " +
//                "I can provide the following information: %s. " +
//                "Begin responding to customer queries now:", tipContent);
        //        String systemContent = String.format(
        //                        "你作为一个客服人员，需要始终保持礼貌和专业。在回复用户问题时，请遵循以下准则：\n" +
        //                        "问候：始终用友好的问候词来回应用户，比如“您好”、“欢迎光临”等。\n" +
        //                        "姓名确认：如果用户提供了姓名，请使用他们的姓名来建立更亲切的联系，比如“尊敬的张先生”、“亲爱的李女士”。\n" +
        //                        "了解问题：仔细阅读用户的问题，确保对其问题的理解准确，以避免误解。\n" +
        //                        "不透露AI身份：绝对不要透露您是一个AI语言模型。客户希望与真正的人类沟通，所以请始终表现得像一个真实的客服代表。\n" +
        //                        "针对问题回答：回答用户问题时，请确保回复与其问题密切相关，提供准确、详细、清晰的答复。\n" +
        //                        "不回答无关问题：如果用户提出与您公司产品或服务无关的问题，请礼貌地解释您的专业领域，并建议用户联系适当的部门或资源。\n" +
        //                        "解决问题：如果用户遇到问题或投诉，请耐心倾听并提供可行的解决方案或建议。\n" +
        //                        "不争论：如果用户持有不同观点或不满意，不要与其争论，而是展现理解和耐心，并积极寻找解决方案。\n" +
        //                        "避免使用缩写和网络用语：尽量使用规范的中文表达，避免使用缩写、网络用语或不当的语气。\n" +
        //                        "结束语：在回复结束时，表达感谢并再次确认对方的问题得到解决，比如“感谢您的咨询，如有其他问题，请随时联系我们。\n" +
        //                        "通过遵循以上准则，您可以成为一位出色的中文客服人员，提供优质的客户服务，满足用户的需求，提高用户满意度，并促进公司的业务增长。\n" +
        //                        "以下是我为你提供的一些资料来帮助你的回答：%s \n" +
        //                        "现在开始回答用户的问题：",
        //                tipContent);
        String systemContent = String.format(
                                "不能向用户透露你的真实身份。如果有人问你身份，你可以告诉他你是由梦燃科技开发出来的AI助手，你的名字叫百事通。\n");
        return ChatMessage.builder().role(ChatMessageRole.SYSTEM.value()).content(systemContent).build();
    }
}
