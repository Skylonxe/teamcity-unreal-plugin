This TeamCity plugin was part of my effort to create all-in-one automation solution for Unreal which could be eventually released on TC marketplace.
The project is abandoned as development priorities shifted elsewhere.

The plugin contains WIP (mostly working) runners for UAT, UBT, UE, Git Dependencies and WIP commit status publisher for UGS badges.

Together with the plugin, there was also optional extensive WIP pipeline setup which I used for experimenting and finding the most optional configuration.
The pipeline was able to configure clean win instances to be able to serve as UE agents, split workload and even individual BuildCookRun step across multiple agents. These agents were then able to reuse artifacts to prevent any work duplication. I exported the TC setup in TeamCity_Backup.zip, however It probably won't be enough to create a new TC instance from it. 

Plugin zip (might not be the latest version matching source):

[unrealPlugin.zip](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/unrealPlugin.zip)

Screenshots:

![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/1.png "1")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/2.png "2")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/3.png "3")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/4.png "4")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/5.png "5")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/6.png "6")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/7.png "7")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/8.png "8")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/9.png "9")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/10.png "10")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/11.png "11")
![alt text](https://github.com/Skylonxe/teamcity-unreal-plugin/tree/master/Screens/12.png "12")