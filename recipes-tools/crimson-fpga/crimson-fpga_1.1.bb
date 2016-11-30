DESCRIPTION = "Pervices Crimson TNG FPGA image"
AUTHOR = "Shiqi Feng <shiqi.f@pervices.com>"
SECTION = "common"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
DEPENDS_${PN} = "bash"
RDEPENDS_${PN} = "useradd bash"
SRC_URI = "file://soc_system.rbf \
	   file://update.sh \
	   file://update.dtb \
          "
FILES_${PN} += "/home/root/pv_fpga/ ${base_libdir} ${sysconfdir}/crimson"

do_install() {
	install -d -m 0755 ${D}/home/root/pv_fpga/
	install -d -m 0755 ${D}${base_libdir}/firmware/
	install -d -m 0755 ${D}${sysconfdir}/crimson/

	install -m 0644 -D ${WORKDIR}/soc_system.rbf ${D}/home/root/pv_fpga/
	install -m 0744 -D ${WORKDIR}/update.sh ${D}/home/root/pv_fpga/
	install -m 0644 -D ${WORKDIR}/update.dtb ${D}/home/root/pv_fpga/

	chown -R root ${D}/home/root
        chgrp -R root ${D}/home/root
}

do_install_append() {
	ln -sf /home/root/pv_fpga/soc_system.rbf ${D}${base_libdir}/firmware/soc_system.rbf
	ln -sf /home/root/pv_fpga/update.dtb ${D}${base_libdir}/firmware/update.dtb
	echo "shipped-${PV}" >> ${D}${sysconfdir}/crimson/${PN}
}
