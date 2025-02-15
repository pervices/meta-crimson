DESCRIPTION = "flashrom is a utility for identifying, reading, writing, verifying and erasing flash chips"
LICENSE = "GPLv2"
HOMEPAGE = "http://flashrom.org"

LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
DEPENDS = "pciutils"

SRC_URI = "https://download.flashrom.org/releases/flashrom-${PV}.tar.bz2 \
           file://0001-Fix-compilation-on-aarch64.patch \
           file://0002-Disable-Wtautological-pointer-compare-when-using-cla.patch \
           file://0003-remove-duplicate-const-qualifiers.patch \
           file://0001-ichspi.c-Fix-build-with-clang.patch \
           "

SRC_URI[md5sum] = "407e836c0a2b17ec76583cb6809f65e5"
SRC_URI[sha256sum] = "6f7b588cce74c90b4fe9c9c794de105de76e0323442fb5770b1aeab81e9d560a"

CFLAGS += "-Wno-error=unknown-pragmas"

do_install() {
    oe_runmake PREFIX=${prefix} DESTDIR=${D} install
}
