inherit core-image

# Ensure your assignment package is installed
IMAGE_INSTALL:append = " aesd-assignments"

# Add SSH support
CORE_IMAGE_EXTRA_INSTALL += " openssh"

inherit extrausers

# Use the hashed version of the password 'root'
# Generated via: mkpasswd -m sha256crypt root
PASSWD = "\$5\$2WoxjAdaC2\$l4aj6Is.EWkD72Vt.byhM5qRtF9HcCM/5YpbxpmvNB5"

EXTRA_USERS_PARAMS = "usermod -p '${PASSWD}' root;"

# This enables root login and allows sshpass to work smoothly
IMAGE_FEATURES += "ssh-server-openssh debug-tweaks"
