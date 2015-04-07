# ServerChangeGui
A plugin utilizing the bungee-api to create an inventory serverlist

Jenkins Dev version:[![Build Status](http://dingemans.ga:8080/buildStatus/icon?job=ServerChangeGui)](http://dingemans.ga:8080/job/ServerChangeGui)

[Normal Releases](https://github.com/bigibas123/ServerChangeGui/releases "Normal Releases")


feel free to contact me about anything
help/merge requests greatly appreciated


##Commands:

  `/bbp` opens the interface


##Example config
```YAML
BasPlugin:
  items:
    main:
      item: STAINED_CLAY
      durability: 4
    skywars:
      item: STAINED_CLAY
      durability: 5
    joran:
      item: STAINED_CLAY
      durability: 6
```

as example the `main:` part show the `item` as stained clay with durability `4` is a yellow stained clay block
for item names see https://hub.spigotmc.org/javadocs/bukkit/index.html?org/bukkit/material/package-summary.html under `Class Summary` and durability's http://minecraft-ids.grahamedgecombe.com/
