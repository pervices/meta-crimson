DESCRIPTION = "Pervices Cyan  webserver and GUI source code"
AUTHOR = "Shiqi Feng <shiqi.f@pervices.com>"
SECTION = "common"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "git://github.com/pervices/webserver.git;protocol=git;branch=ops/ggan/master \
           file://lib/systemd/system/cyan-website.service \
          "
SRCREV = "ops/ggan/master"
BRANCH = "ops/ggan/master"

S = "${WORKDIR}/git/tate/"

RDEPENDS_${PN} = "nodejs"

inherit systemd npm-install-global allarch

FILES_${PN} += "${systemd_unitdir}/system ${sysconfdir}/cyan"

SYSTEMD_SERVICE_${PN} = "cyan-website.service"

do_install_append() {
	install -d -m 0755 ${D}${systemd_unitdir}/system/
	install -d -m 0755 ${D}${sysconfdir}/cyan/
	install -m 0644 -D ${WORKDIR}/lib/systemd/system/cyan-website.service ${D}${systemd_unitdir}/system/
	#ln -s /usr/lib/node_modules/cyan-webserver/public/js/jquery-1.11.2.min.js ${D}${libdir}/node_modules/cyan-webserver/public/js/jquery.min.js
	#chown -R root ${D}${libdir}/node_modules/cyan-webserver
	#echo "${BRANCH}:${SRCREV}" > ${D}${sysconfdir}/cyan/${PN}
}
