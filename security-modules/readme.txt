secure-ui
• redorects tp gothub for login and gets auth token
• obtains reports from secure-service

secure-service
• validates user's token against github or custom auth service
• validates if user is authorized for an operation

secure-auth-server
• custom auth service that can be used instead to authorize users

secure-cli
• can be used for testing a custom auth service
• an alternative can be a direct GET request with parameters:
  • grant_type=password
  • client_id=pluralsight
  • username=bgoldberg
  • password=pass2