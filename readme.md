# SimpleHub

SimpleHub is a straightforward and efficient plugin designed to teleport players to a predefined hub world with specified coordinates. This plugin is ideal for servers using Multiverse, offering a simple `/hub` or `/lobby` command to teleport players to the main hub.

## Features

- Teleport players to a specific hub world and coordinates.
- Customizable message upon teleportation.
- Compatible with Multiverse.
- Easy to configure and use.

## Installation

1. **Download** the latest version of `SimpleHub.jar` from the [releases page](https://github.com/FlingisenFlong/SimpleHub/releases/).
2. Place the `SimpleHub.jar` file in your server's `plugins` directory.
3. Restart your server to generate the default configuration file.
4. Configure the plugin by editing the `config.yml` file located in the `plugins/SimpleHub` folder.

## Tested versions
**1.21**

## Configuration

The configuration file `config.yml` looks like this:

```yaml
# SimpleHub configuration for Multiverse
world: myHubWorldName  # Change this to the name of your hub world
x: 0
y: 64
z: 0
confirmmsg: "&aTeleported to hub successfully!"
```

## Building from Source

If you wish to build the plugin from source, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/FlingisenFlong/SimpleHub.git
   cd SimpleHub
