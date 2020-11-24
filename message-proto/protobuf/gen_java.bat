set in_put="..\protobuf"
set out_put="..\src\main\java"



protoc -I=%in_put% --java_out=%out_put% %in_put%\member_status_message.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\matching_room_error_code.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\matching_room_request_opcode.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\gateway_error_code.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\gateway_notify_opcode.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\gateway_request_code.proto

pause