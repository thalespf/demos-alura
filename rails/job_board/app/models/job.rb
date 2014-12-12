class Job < ActiveRecord::Base

  #Relationships
  has_many :comments

  scope :most_recent, lambda { order("created_at DESC") }

  scope 

end
