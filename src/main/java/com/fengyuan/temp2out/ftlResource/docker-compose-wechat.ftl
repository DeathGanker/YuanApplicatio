version: '2.0'
services:
  chatgpt-on-wechat:
    image: ${image}
    container_name: ${containerName}
    security_opt:
      - seccomp:unconfined
    environment:
      OPEN_AI_API_KEY: '${openAIAPIKey}'
      OPEN_AI_API_BASE: '${openAIApiBase}'
      MODEL: '${model}'
      CHANNEL_TYPE: 'wx'
      PROXY: ''
      HOT_RELOAD: 'True'
      SINGLE_CHAT_PREFIX: '[""]'
      SINGLE_CHAT_REPLY_PREFIX: '""'
      GROUP_CHAT_PREFIX: '["@${groupChatPrefix}"]'
      GROUP_NAME_WHITE_LIST: '[${groupNameWhiteList}]'
      IMAGE_CREATE_PREFIX: '["画", "看", "找"]'
      CONVERSATION_MAX_TOKENS: 1000
      SPEECH_RECOGNITION: 'True'
      CHARACTER_DESC: '${characterDesc}'
      SUBSCRIBE_MSG: '${subscribeMsg}}'
      EXPIRES_IN_SECONDS: 3600
      USE_GLOBAL_PLUGIN_CONFIG: 'True'
      USE_LINKAI: 'False'
      LINKAI_API_KEY: ''
      LINKAI_APP_CODE: ''
      VOICE_TO_TEXT: '${voiceToText}'
      BAIDU_APP_ID: '${baiduAppId}'
      BAIDU_API_KEY: '${baiduApiKey}'
      BAIDU_SECRET_KEY: '${baiduSecretKey}'