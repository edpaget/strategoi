# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

install = <<BASH
apt-get update
apt-get install apt-transport-https -y -q
apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 36A1D7869245C8950F966E92D8576A8BA88D21E9
sh -c "echo deb https://get.docker.io/ubuntu docker main > /etc/apt/sources.list.d/docker.list"
apt-get update
apt-get install -y -q curl python-setuptools python-pip python-dev python-protobuf zookeeperd lxc-docker
sudo mkdir -p /etc/mesos-master
echo 1 | sudo dd of=/var/lib/zookeeper/myid
curl -sfL http://downloads.mesosphere.io/master/ubuntu/14.04/mesos_0.19.0-xcon3_amd64.deb -o /tmp/mesos.deb
dpkg -i /tmp/mesos.deb
curl -sfL http://downloads.mesosphere.io/marathon/marathon_0.5.0-xcon2_noarch.deb -o /tmp/marathon.deb
dpkg -i /tmp/marathon.deb
echo in_memory  | sudo dd of=/etc/mesos-master/registry
pip install deimos
mkdir -p /etc/mesos-slave
echo /usr/local/bin/deimos  | sudo dd of=/etc/mesos-slave/containerizer_path
echo external     | sudo dd of=/etc/mesos-slave/isolation
service docker restart
service zookeeper restart
service mesos-master restart
service mesos-slave restart
service marathon restart
BASH

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "phusion-open-ubuntu-14.04-amd64"
  config.vm.box_url = "https://oss-binaries.phusionpassenger.com/vagrant/boxes/latest/ubuntu-14.04-amd64-vbox.box"
  config.vm.network :forwarded_port, guest: 8080, host: 8080
  config.vm.network :forwarded_port, guest: 5050, host: 5050
  config.vm.network "private_network", ip: "192.168.50.4"
  config.vm.hostname = "mesos"

  config.vm.provider "virtualbox" do |v|
    v.memory = 2048
  end

  config.vm.provision "shell", inline: install
end
