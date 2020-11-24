
set in_put="..\protobuf"
set gateway_out_put="..\gateway\src\main\java"

set pa=%cd%
cd %gateway_out_put%\com\sj\game\proto
del /S /Q *
cd %pa%
cd %out_put%\com\sjhy\texas\proto
del /S /Q *
cd %pa%

protoc -I=%in_put% --java_out=%out_put% %in_put%\HallDs.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\GameServer.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\Hall.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\HallBase.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\Texas.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\GameBase.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\GamePushDot.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\Gateway.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\RedBlackWars.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\HundredNiuNiu.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\Slot777.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\Esports.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\TimelyLottery.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\FishingJoy.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\PaoDeKuai.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\SuperNiuNiu.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\Rummy.proto
protoc -I=%in_put% --java_out=%out_put% %in_put%\titian.proto

pause

