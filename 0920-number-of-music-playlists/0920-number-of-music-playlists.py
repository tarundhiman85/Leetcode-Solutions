class Solution:
    def numMusicPlaylists(self, n: int, goal: int, k: int) -> int:
        MOD = 1_000_000_007
        dp = {}
        def count(curr_goal, old_songs):
            # Base case: if the current goal is 0 and all old songs are used, return 1
            if curr_goal == 0 and old_songs == n:
                return 1
            # Base cases: if the current goal is 0 or more old songs are used than available, return 0
            if curr_goal == 0 or old_songs > n:
                return 0
            if (curr_goal, old_songs) in dp:
                return dp[(curr_goal, old_songs)]
            # Choose a new song: There are (n - old_songs) options for new songs.
            # Multiply by the result of the recursive call with decreased goal and increased old_songs.
            res = (n - old_songs) * count(curr_goal - 1, old_songs + 1)
            
            # Choose an old song: Only choose an old song if there are more old songs than k.
            if old_songs > k:
                # There are (old_songs - k) options for old songs.
                # Multiply by the result of the recursive call with decreased goal and same old_songs.
                res += (old_songs - k) * count(curr_goal - 1, old_songs)
            dp[(curr_goal, old_songs)] = res % MOD  
            # Return the result modulo MOD value to avoid large numbers
            return dp[(curr_goal, old_songs)]
        
        # Start the recursive function with the initial goal and 0 old songs
        return count(goal, 0)
