require base-image.inc
IMAGE_INSTALL += "cyan-firmware-4r4t-1g"
export IMAGE_BASENAME = "4r4t-1g"

UBOOT_BINARY = "u-boot-dtb.img"

IMAGE_FSTYPES += "wic"

WKS_FILE = "4r4t-1g.wks"

IMAGE_BOOT_FILES ?= " \
                        ${UBOOT_BINARY} \
                        ${KERNEL_IMAGETYPE} \
                        socfpga_stratix10_socdk.dtb \
                        u-boot.scr \
                    "

do_image_wic[depends] += "mtools-native:do_populate_sysroot dosfstools-native:do_populate_sysroot virtual/bootloader:do_deploy virtual/kernel:do_deploy"
