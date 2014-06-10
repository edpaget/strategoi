# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

install = <<BASH
apt-get update -q
apt-get install -y -q curl python-setuptools python-pip python-dev python-protobuf zookeeperd docker.io
sudo ln -sf /usr/bin/docker.io /usr/local/bin/docker
sudo mkdir -p /etc/mesos-master
echo 1 | sudo dd of=/var/lib/zookeeper/myid
curl -sfL http://downloads.mesosphere.io/master/ubuntu/13.10/mesos_0.19.0-xcon3_amd64.deb -o /tmp/mesos.deb
dpkg -i /tmp/mesos.deb
curl -sfL http://downloads.mesosphere.io/marathon/marathon_0.5.0-xcon2_noarch.deb -o /tmp/marathon.deb
dpkg -i /tmp/marathon.deb
echo in_memory  | sudo dd of=/etc/mesos-master/registry
service docker.io restart
service zookeeper restart
service mesos-master restart
service mesos-slave restart
pip install deimos
mkdir -p /etc/mesos-slave
echo /usr/bin/deimos  | sudo dd of=/etc/mesos-slave/containerizer_path
echo external     | sudo dd of=/etc/mesos-slave/isolation
service marathon restart
BASH

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "phusion-open-ubuntu-14.04-amd64"
  config.vm.box_url = "https://oss-binaries.phusionpassenger.com/vagrant/boxes/latest/ubuntu-14.04-amd64-vbox.box"
  config.vm.network :forwarded_port, guest: 8080, host: 8080

  config.vm.provision "shell", inline: install
end
