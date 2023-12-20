import java.util.ArrayList;
class Solution {
    public String solution(String m, String[] musicinfos) {
        ArrayList<String[]> musicArr = new ArrayList<>();
        for(String music : musicinfos){
            String[] info = music.split(",");
            String[] s = info[0].split(":");
            String[] e = info[1].split(":");
            int playTime = 0;
            playTime += (Integer.parseInt(e[0]) - Integer.parseInt(s[0])) * 60;
            playTime += Integer.parseInt(e[1]) - Integer.parseInt(s[1]);
            int musicLength = info[3].replace("#", "").length();
            int t = 0;
            int sharp = 0;
            while(t <= playTime % musicLength){
                if(info[3].charAt(t + sharp) == '#') sharp++;
                else t++;
            }
            if(playTime < musicLength) info[3] = info[3].substring(0, playTime + sharp);
            else{
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < playTime / musicLength; i++) sb.append(info[3]);
                sb.append(info[3].substring(0, playTime % musicLength + sharp));
                info[3] = sb.toString();
            }
            if(info[3].replaceAll(m + "#", " ").contains(m)){
                musicArr.add(new String[]{info[2], String.valueOf(playTime)});
            }
        }
        if(musicArr.isEmpty()) return "(None)";
        musicArr.sort((o1, o2) -> Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]));
        return musicArr.get(0)[0];
    }
}