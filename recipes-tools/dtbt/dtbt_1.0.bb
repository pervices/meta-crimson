DESCRIPTION = "Device Tree Overlay management tool (dtbt)"
AUTHOR = "Yves Vandervennet <yvanderv@altera.com>"
SECTION = "tools"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=a2ba7b0b13b47f38afcb77908570c045"

S="${WORKDIR}/git"

DTBT_REPO ?= "git://github.com/altera-opensource/dtbt"
DTBT_PROT ?= "https"
DTBT_BRANCH ?= "master"
SRCREV = "feb65a1ff248d03bc390691aa77dad190313a852"

RPROVIDES_${PN} = "dtbt"

SRC_URI = "${DTBT_REPO};protocol=${DTBT_PROT};branch=${DTBT_BRANCH}"

FILES_${PN} = "/sbin/dtbt"
FILES_${PN}-dbg = ""

RDEPENDS_${PN}="python python-modules"

PR = "r5"

do_compile() {
        :
}

do_install() {
	cd ${S}
        ls -l
        install -d ${D}/sbin
        install -m 0755 dtbt ${D}/sbin/dtbt
}

