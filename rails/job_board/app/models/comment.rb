class Comment < ActiveRecord::Base

  validates_presence_of :body, :name

  belongs_to :job

end
