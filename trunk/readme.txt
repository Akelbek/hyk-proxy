hyk-proxy 0.2.0  Read Me
Release 2010/01/31
http://hyk-proxy.googlecode.com 

This file is part of hyk-proxy.                                   
                                                                  
hyk-proxy is free software: you can redistribute it and/or modify 
it under the terms of the GNU General Public License as           
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.                   
                                                                  
hyk-proxy is distributed in the hope that it will be useful,      
but WITHOUT ANY WARRANTY; without even the implied warranty of    
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the     
GNU General Public License for more details.                      
                                                                  
You should have received a copy of the GNU General Public License 
along with GAppProxy.  If not, see <http://www.gnu.org/licenses/>.

Dependencies
------------
1. You need to install JRE/JDK(5+).
2. You need to install Google App Engine SDK(Java) (developed under 1.3.0, don't test earlier version)

INSTALL:
GAE server part����GAE server���֣�
 1. unzip hyk-proxy-server-[version].zip
    ����Ŀ¼�½�ѹhyk-proxy-server-[version].zip
 2. cd hyk-proxy-server-[version] 
    �����ѹ��Ŀ¼
 3. modify war/WEB-INF/appengine-web.xml, change the element '<application>hyk-proxy-demo</application>'
    �޸�war/WEB-INF/appengine-web.xml�� ��'<application>'ֵ��Ϊ�Լ�������appid
 4. execute appcfg update (make sure you are in the directory 'hyk-proxy-server-[version]')
    ִ��appcfg.cmd/appcfg.sh update war�ϴ�
    
GAE client part: ��GAE client���֣�
  1. unzip hyk-proxy-client-[version].zip
    ����Ŀ¼�½�ѹhyk-proxy-client-[version].zip
  2. cd hyk-proxy-client-[version] 
    �����ѹ��Ŀ¼
  3. modify etc/hyk-proxy-client.properties, refer the comment for more information
    ����ע���޸�etc/hyk-proxy-client.properties
  4. execute bin/start.bat(start.sh) to start the local server, execute bin/stop.bat to stop it
    ִ��bin/start.bat(start.sh)����local server��bin/stop.bat(stop.sh)ֹͣ

 