# Zune Modding Firmware Web Server 📱
The Zune Modding Firmware Web Server aim to allow everyone of pushing any files to their Zune with a patched version of the Zune Software 1.3.5728.0

<div id="header" align="center">
  <img src="https://github.com/zunes/ZuneModdingFirmwareWebServer/assets/44437316/38e49c1f-a0bb-45a5-991c-3f5dac84ef2f" width="250"/>
  <img src="https://github.com/zunes/ZuneModdingFirmwareWebServer/assets/44437316/52a642e4-a321-493f-b41a-01dd4560253e" width="250"/>
  <img src="https://github.com/zunes/ZuneModdingFirmwareWebServer/assets/44437316/9b35348e-531a-4669-ba1e-174f2f2f6b40" width="250"/>
</div>

# What's the point ?.. Nerd 🤓
Good question ! For regular users you can **inject fonts** but only on the Zune 30 and with the **1.X firmware**, you can also just downgrade your Zune like that. In fact this could be useful for **reverse-engineering**, **exploits** and **modding**. Remember : The Zune had zero real firmware exploit for now ! Not even a Rockbox firmware, even if the Zune 30 was made with a Toshiba Gigabit that had a Rockbox firmware already.

# How does it work ? 🤔
It all started with a very old exploit made by some Chinese hacking groups to push Asian fonts to the Zune.[^1]
In fact we can take advantage of it to push any files we want to the Zune ! When the Zune is updating now the Zune Software checks the signature of the firmware downloaded (.cab) and if it is wrong the firmware isn't pushed to the Zune. The patched Zune Software 1.3.5728.0 doesn't check the firmware and push it to the Zune. Sadly the Zune check the firmware too and threw the firmware if it is invalid, but we can put other files at the same time ! Fonts work for example for older 1.X firmwares and we can exchange Recovery, bootloader and NK for the same Zune model.

# What's working ? 👌
+ **Adding fonts** in the Fonts directory (it's because WinCE had a Fonts folder next to the Windows system one), only working on Z1H (Keel) with 1.X version
+ **Bootloader 1003** (firmware **Draco** 2.1) onto the **firmware 3.30** (normally bootloader 1620)
+ **Bootloader 325** (firmware **Keel** 1.1) onto the **firmware 3.30** (normally bootloader 420)
+ Pushing the official **Games.cab** signed by Microsoft

# What's not ? ❌
+ Create **custom Games.cab** and push it to the Zune with one deleted .zcp (the cab is signed by Microsoft so it doesn't work)
+ Edited nk.bin firmware file with WinCE firmware "editor" or "kitchen", should be the same for others .bin firmware files
+ Trying to **push existing system files onto the official ones** (ex replacing the existing wallpapers with custom ones)
+ Bootloader 325 (firmware Keel 1.1) onto the firmware 3.30 (normally bootloader 420) **with fonts**

# Warnings ! ⚠️
+ I'VE NOT TESTED THIS METHOD WITH A ZUNE HD AND A ZUNE 2ND GEN FLASH ! DO AT YOUR OWN RISK ! For the Z2F it should be ok but maybe not for the Zune HD.
+ All of this is not official and experimental.
+ You are responsible for what you are doing, I can help you but I am not responsible for your mistakes.
+ I **bricked my Zune** installing the "Zune (TEST)" firmware. This firmware aim to force the Zune to use MTP instead of ZMTP but sadly after a reset you can't restore your Zune with the Zune Software.

# Requirements 🗒️
+ Zune Software 1.3.5728.0[^2] (A Windows XP VM is recommended ! Compatible with external USB support)
+ The patched zunelib.dll[^3] placed into `C:\Program Files\Zune`
+ A DNS server that redirects `media.zune.net`, `go.microsoft.com` and `msxb-d1.vo.llnw.net` to the IP where the ZuneModdingFirmwareWebServer.jar is running
+ Java Runtime Environment (JRE) 6 to 8.0[^4]
+ The ZuneModdingFirmwareWebServer.jar ! In the release of this Git page.

+ Install firmware 1.0 with **nk.bin from Gigabit**
+ Install firmware 1.0 with **nk.bin AND recovery.bin from Gigabit** : It don't even bother trying to install it (check at boot ?)

# How to modify and compile ZuneModdingFirmwareWebServer.jar (easy method)
Go to [CompileJava.net](https://www.compilejava.net/), rename the first tab `httpRequesthandler.java` and open a second tabs that you name `httpServer.java`. You can now paste the sourcecode of the two .java files in the repo.

[^1]: [Tutorial for pushing Asian fonts to the Zune 30 Keel](https://bjmingyang.blogspot.com/2009/03/zune.html)
[^2]: [Zune Software 1.3.5728.0](https://onedrive.live.com/?authkey=%21APGZWB8OY8tE9Xo&cid=08EA7CE299BC476C&id=8EA7CE299BC476C%21218786&parId=8EA7CE299BC476C%21199112&o=OneUp)
[^3]: [Patched zunelib.dll](https://www.mediafire.com/?qipbdc8p4qizx)
[^4]: [Java Runtime Environment (JRE)](https://www.java.com/fr/download/manual.jsp)
